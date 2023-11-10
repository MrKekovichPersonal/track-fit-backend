package com.mrkekovich.trackfitbackend.services

import com.mrkekovich.trackfitbackend.dto.FoodDto
import com.mrkekovich.trackfitbackend.repositories.FoodRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class FoodService(
    val foodRepository: FoodRepository
) {
    fun create(foodDto: FoodDto.Request): ResponseEntity<FoodDto.Response> {
        val entity = foodRepository.save(foodDto.toEntity())
        return ResponseEntity(
            FoodDto.Response(entity),
            HttpStatus.CREATED
        )
    }

    fun getAll(): ResponseEntity<List<FoodDto.Response>> {
        val response = foodRepository.findAll().map {
            FoodDto.Response(it)
        }

        return ResponseEntity(
            response,
            HttpStatus.OK
        )
    }

    fun getById(id: String): ResponseEntity<FoodDto.Response> {
        val entity = foodRepository.findById(id).getOrNull()
            ?: return ResponseEntity(
                HttpStatus.NOT_FOUND
            )

        return ResponseEntity(
            FoodDto.Response(entity),
            HttpStatus.OK
        )
    }

    fun update(id: String, foodDto: FoodDto.Request): ResponseEntity<FoodDto.Response> {
        foodRepository.findById(id).getOrNull()
            ?: return ResponseEntity(
                HttpStatus.NOT_FOUND
            )

        val response = FoodDto.Response(
            foodRepository.save(
                foodDto.toEntity(id)
            )
        )

        return ResponseEntity(
            response,
            HttpStatus.OK
        )
    }

    fun delete(id: String): ResponseEntity<HttpStatus> {
        val entity = foodRepository.findById(id).getOrNull()
            ?: return ResponseEntity(
                HttpStatus.NOT_FOUND
            )

        foodRepository.delete(entity)

        return ResponseEntity(
            HttpStatus.OK
        )
    }

}