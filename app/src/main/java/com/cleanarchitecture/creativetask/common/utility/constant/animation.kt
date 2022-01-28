package com.cleanarchitecture.creativetask.common.utility.constant

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring

val springAnimation = spring(
    dampingRatio = Spring.DampingRatioMediumBouncy,
    stiffness = Spring.StiffnessLow,
    visibilityThreshold = 0.001f
)