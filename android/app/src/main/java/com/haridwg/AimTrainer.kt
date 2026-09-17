package com.haridwg

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import kotlin.math.sqrt
import kotlin.random.Random

class AimTrainer(
    context: Context
) : View(context) {

    private val paint =
        Paint(Paint.ANTI_ALIAS_FLAG)

    private var target: AimTarget? = null

    private var score = 0
    private var shots = 0

    init {
        spawn()
    }

    private fun spawn() {

        val safeWidth =
            width.coerceAtLeast(1)

        val safeHeight =
            height.coerceAtLeast(1)

        val x =
            Random.nextFloat() *
                safeWidth * 0.75f +
                safeWidth * 0.125f

        val y =
            Random.nextFloat() *
                safeHeight * 0.70f +
                safeHeight * 0.15f

        target = AimTarget(
            x = x,
            y = y,
            radius = 55f,
            zone = HitZone.NECK
        )
    }

    override fun onDraw(canvas: Canvas) {

        super.onDraw(canvas)

        canvas.drawColor(
            Color.rgb(8, 8, 11)
        )

        paint.color = Color.WHITE
        paint.textSize = 32f

        canvas.drawText(
            "HARIDWG AIM TRAINER",
            25f,
            50f,
            paint
        )

        paint.textSize = 22f

        canvas.drawText(
            "Score: $score",
            25f,
            90f,
            paint
        )

        canvas.drawText(
            "Shots: $shots",
            25f,
            120f,
            paint
        )

        val t = target ?: return

        paint.color =
            Color.rgb(210, 45, 55)

        canvas.drawCircle(
            t.x,
            t.y,
            t.radius,
            paint
        )

        paint.color = Color.WHITE
        paint.textSize = 15f

        canvas.drawText(
            t.zone.name,
            t.x - t.radius,
            t.y + 5f,
            paint
        )
    }

    override fun onTouchEvent(
        event: MotionEvent
    ): Boolean {

        if (
            event.action !=
            MotionEvent.ACTION_DOWN
        ) {
            return true
        }

        shots++

        val t = target

        if (t != null) {

            val dx =
                event.x - t.x

            val dy =
                event.y - t.y

            val distance =
                sqrt(
                    dx * dx +
                    dy * dy
                )

            if (distance <= t.radius) {

                score +=
                    when (t.zone) {

                        HitZone.HEAD ->
                            3

                        HitZone.NECK ->
                            2

                        else ->
                            1
                    }

                spawn()
            }
        }

        invalidate()

        return true
    }
}
