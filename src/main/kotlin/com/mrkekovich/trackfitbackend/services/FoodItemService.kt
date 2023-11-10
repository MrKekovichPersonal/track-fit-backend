package com.mrkekovich.trackfitbackend.services

import com.mrkekovich.trackfitbackend.repositories.FoodItemRepository
import org.springframework.stereotype.Service

@Service
class FoodItemService(
    val foodItemRepository: FoodItemRepository
) {

}