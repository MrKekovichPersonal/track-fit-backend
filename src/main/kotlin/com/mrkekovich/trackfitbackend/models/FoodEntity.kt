package com.mrkekovich.trackfitbackend.models

import jakarta.persistence.*

@Entity
@Table(name = "foods")
class FoodEntity(
    @Column(name = "name")
    val name: String?,

    @Column(name = "description")
    val description: String?,

    @Column(name = "image")
    val image: String?,

    @Column(name = "commentary")
    val commentary: String?,

    @Column(name = "calories")
    val calories: Int?,

    @Column(name = "protein")
    val protein: Int?,

    @Column(name = "carbs")
    val carbs: Int?,

    @Column(name = "fat")
    val fat: Int?,

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String? = null
)