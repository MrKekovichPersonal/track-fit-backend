package com.mrkekovich.trackfitbackend.controllers

import com.mrkekovich.trackfitbackend.dto.FoodDto
import com.mrkekovich.trackfitbackend.services.FoodService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/foods")
class FoodController(
    val foodService: FoodService
) {
    @PostMapping
    fun create(
        @Validated
        @RequestBody
        foodDto: FoodDto.Request
    ): ResponseEntity<FoodDto.Response> =
        foodService.create(foodDto)

    @GetMapping
    fun getAll(): ResponseEntity<List<FoodDto.Response>> =
        foodService.getAll()

    @GetMapping("/{id}")
    fun getById(
        @Validated
        @PathVariable
        id: String
    ): ResponseEntity<FoodDto.Response> =
        foodService.getById(id = id)

    @PatchMapping("/{id}")
    fun update(
        @Validated
        @PathVariable
        id: String,

        @Validated
        @RequestBody
        foodDto: FoodDto.Request
    ): ResponseEntity<FoodDto.Response> =
        foodService.update(
            id = id,
            foodDto = foodDto
        )

    @DeleteMapping("/{id}")
    fun delete(
        @Validated
        @PathVariable
        id: String
    ): ResponseEntity<HttpStatus> =
        foodService.delete(id = id)
}











