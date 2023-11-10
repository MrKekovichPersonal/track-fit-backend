package com.mrkekovich.trackfitbackend.repositories

import com.mrkekovich.trackfitbackend.models.FoodEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FoodRepository : JpaRepository<FoodEntity, String>