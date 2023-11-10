package com.mrkekovich.trackfitbackend.controllers

import com.mrkekovich.trackfitbackend.dto.FoodItemDto
import com.mrkekovich.trackfitbackend.services.FoodItemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/food-items")
class FoodItemController(
    val foodItemService: FoodItemService
) {
    @PostMapping
    fun create(
        @Validated
        @RequestBody
        foodItemDto: FoodItemDto.Request
    ): ResponseEntity<FoodItemDto.Response> =
        foodItemService.create(foodItemDto)

    @GetMapping
    fun getAll(): ResponseEntity<List<FoodItemDto.Response>> =
        foodItemService.getAll()

    @GetMapping("/{id}")
    fun getById(
        @Validated
        @PathVariable
        id: String
    ): ResponseEntity<FoodItemDto.Response> =
        foodItemService.getById(id = id)

    @PatchMapping("/{id}")
    fun update(
        @Validated
        @PathVariable
        id: String,

        @Validated
        @RequestBody
        foodItemDto: FoodItemDto.Request
    ): ResponseEntity<FoodItemDto.Response> =
        foodItemService.update(
            id = id,
            foodItemDto = foodItemDto
        )

    @DeleteMapping("/{id}")
    fun delete(
        @Validated
        @PathVariable
        id: String
    ): ResponseEntity<HttpStatus> =
        foodItemService.delete(id = id)
}











