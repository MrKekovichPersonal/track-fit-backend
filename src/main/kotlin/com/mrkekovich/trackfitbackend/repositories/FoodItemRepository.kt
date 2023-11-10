package com.mrkekovich.trackfitbackend.repositories

import com.mrkekovich.trackfitbackend.models.FoodItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FoodItemRepository : JpaRepository<FoodItemEntity, String>