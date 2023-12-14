package com.example.android5.data

import kotlinx.serialization.Serializable
import kotlin.collections.ArrayList

@Serializable
data class ApiResponse(
    val name: String?=null,
    val culture: String?=null,
    val born: String?=null,
    val titles:List<String>,
    val aliases:List<String>,
    val playedBy:List<String>
)
