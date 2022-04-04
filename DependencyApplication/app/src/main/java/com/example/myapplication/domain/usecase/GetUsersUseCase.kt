package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repository.UserRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    //suspend fun execute(): List<User> = userRepository.getUser()
    // GetUserUseCase()를 할 때 바로 getUser()이 되도록 하기 위해 operator를 사용
    suspend operator fun invoke() = userRepository.getUser()
}