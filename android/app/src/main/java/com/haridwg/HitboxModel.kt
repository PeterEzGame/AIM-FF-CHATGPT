package com.haridwg

enum class HitZone {

    LEFT_HAND,
    RIGHT_HAND,

    BODY,

    NECK,

    HEAD,

    LEFT_LEG,
    RIGHT_LEG
}

data class AimTarget(
    val x: Float,
    val y: Float,
    val radius: Float,
    val zone: HitZone
)
