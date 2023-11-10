package com.mrkekovich.trackfitbackend.services

import com.mrkekovich.trackfitbackend.dto.FoodItemDto
import com.mrkekovich.trackfitbackend.repositories.FoodItemRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class FoodItemService(
    val foodItemRepository: FoodItemRepository
) {
    fun create(foodItemDto: FoodItemDto.Request): ResponseEntity<FoodItemDto.Response> {
        val entity = foodItemRepository.save(foodItemDto.toEntity())
        return ResponseEntity(
            FoodItemDto.Response(entity),
            HttpStatus.CREATED
        )
    }

    fun getAll(): ResponseEntity<List<FoodItemDto.Response>> {
        val response = foodItemRepository.findAll().map {
            FoodItemDto.Response(it)
        }

        return ResponseEntity(
            response,
            HttpStatus.OK
        )
    }

    fun getById(id: String): ResponseEntity<FoodItemDto.Response> {
        val entity = foodItemRepository.findById(id).getOrNull()
            ?: return ResponseEntity(
                HttpStatus.NOT_FOUND
            )

        return ResponseEntity(
            FoodItemDto.Response(entity),
            HttpStatus.OK
        )
    }

    fun update(id: String, foodItemDto: FoodItemDto.Request): ResponseEntity<FoodItemDto.Response> {
        foodItemRepository.findById(id).getOrNull()
            ?: return ResponseEntity(
                HttpStatus.NOT_FOUND
            )

        val response = FoodItemDto.Response(
            foodItemRepository.save(
                foodItemDto.toEntity(id)
            )
        )

        return ResponseEntity(
            response,
            HttpStatus.OK
        )
    }

    fun delete(id: String): ResponseEntity<HttpStatus> {
        val entity = foodItemRepository.findById(id).getOrNull()
            ?: return ResponseEntity(
                HttpStatus.NOT_FOUND
            )

        foodItemRepository.delete(entity)

        return ResponseEntity(
            HttpStatus.OK
        )
    }

}