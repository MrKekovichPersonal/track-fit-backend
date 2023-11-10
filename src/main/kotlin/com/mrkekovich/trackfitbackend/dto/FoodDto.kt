package com.mrkekovich.trackfitbackend.dto

import com.mrkekovich.trackfitbackend.models.FoodEntity
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

/**
 * Food item dto
 *
 * A sealed class with abstract values.
 * Used as a parent class for Response and Request data classes.
 */
sealed class FoodDto {
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

    /**
     * To entity
     *
     * Converts data class to entity, using its values.
     *
     * @return The converted FoodEntity object.
     */
    fun toEntity(): FoodEntity {
        return FoodEntity(
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

    /**
     * To Entity
     *
     * Converts a data class to a food entity object.
     *
     * @param id The ID of the entity.
     * @return The converted FoodEntity object.
     */
    fun toEntity(id: String): FoodEntity {
        return FoodEntity(
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

    /**
     * Response DTO
     *
     * Used to validate output data.
     */
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
    ) : FoodDto() {
        constructor(entity: FoodEntity) : this(
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

    /**
     * Request
     *
     * Used to validate input data.
     */
    data class Request(
        override val name: String?,
        override val description: String?,
        override val image: String?,
        override val commentary: String?,
        override val calories: Int?,
        override val protein: Int?,
        override val carbs: Int?,
        override val fat: Int?,
    ) : FoodDto()
}














