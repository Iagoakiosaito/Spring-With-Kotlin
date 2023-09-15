package com.gubee.springWithKotlin.unit

import com.gubee.springWithKotlin.models.Client
import com.gubee.springWithKotlin.repository.ClientRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class ClientRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val clientRepository: ClientRepository) {

    @Test
    fun `When findByLogin then return User`() {
        val johnDoe = Client("johnDoe", "John", "Doe")
        entityManager.persist(johnDoe)
        entityManager.flush()
        val user = clientRepository.findByLogin(johnDoe.login)
        assertThat(user).isEqualTo(johnDoe)
    }
}