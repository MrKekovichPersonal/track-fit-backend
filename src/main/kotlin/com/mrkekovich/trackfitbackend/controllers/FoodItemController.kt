package com.mrkekovich.trackfitbackend.controllers

import com.mrkekovich.trackfitbackend.services.FoodItemService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/food-items")
class FoodItemController(
    val foodItemService: FoodItemService
) {
}