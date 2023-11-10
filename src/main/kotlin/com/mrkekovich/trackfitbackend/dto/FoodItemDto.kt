package com.mrkekovich.trackfitbackend.dto

import com.mrkekovich.trackfitbackend.models.FoodItemEntity
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

sealed class FoodItemDto {
    @get:NotBlank
    @get:NotNull
    abstract val name: String?

    abstract val description: String?

    abstract val image: String?

    abstract val commentary: String?

    @get:NotNull
    @get:Min(0, message = "Calories must be positive or 0")
    abstract val calories: Int?

    @get:NotNull
    @get:Min(0, message = "Protein must be positive or 0")
    abstract val protein: Int?

    @get:NotNull
    @get:Min(0, message = "Carbs must be positive or 0")
    abstract val carbs: Int?

    @get:NotNull
    @get:Min(0, message = "Fat must be positive or 0")
    abstract val fat: Int?

    open val id: String? = null

    fun toEntity(): FoodItemEntity {
        return FoodItemEntity(
            name = name,
            description = description,
            image = image,
            commentary = commentary,
            calories = calories,
            protein = protein,
            carbs = carbs,
            fat = fat,
            id = id
        )
    }

    fun toEntity(id: String): FoodItemEntity {
        return FoodItemEntity(
            name = name,
            description = description,
            image = image,
            commentary = commentary,
            calories = calories,
            protein = protein,
            carbs = carbs,
            fat = fat,
            id = id
        )
    }

    data class Response(
        override val name: String?,
        override val description: String?,
        override val image: String?,
        override val commentary: String?,
        override val calories: Int?,
        override val protein: Int?,
        override val carbs: Int?,
        override val fat: Int?,

        @NotNull
        @NotBlank
        override val id: String?
    ) : FoodItemDto() {
        constructor(entity: FoodItemEntity) : this(
            name = entity.name,
            description = entity.description,
            image = entity.image,
            commentary = entity.commentary,
            calories = entity.calories,
            protein = entity.protein,
            carbs = entity.carbs,
            fat = entity.fat,
            id = entity.id
        )
    }

    data class Request(
        override val name: String?,
        override val description: String?,
        override val image: String?,
        override val commentary: String?,
        override val calories: Int?,
        override val protein: Int?,
        override val carbs: Int?,
        override val fat: Int?,
    ) : FoodItemDto()
}














