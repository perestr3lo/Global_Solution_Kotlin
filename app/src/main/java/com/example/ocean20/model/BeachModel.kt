package com.example.ocean20.model

data class BeachModel(
    val id: Int,
    val name: String,
    val city: String,
    val state: String,
    val onRemove: (BeachModel) -> Unit)