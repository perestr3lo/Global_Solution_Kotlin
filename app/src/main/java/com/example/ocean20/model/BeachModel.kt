package com.example.ocean20.model

data class BeachModel(
    val id: Int,
    val nameBeach: String,
    val nameCity: String,
    val nameState: String,
    val onRemove: (BeachModel) -> Unit)