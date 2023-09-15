package com.gubee.springWithKotlin.configuration

import com.gubee.springWithKotlin.models.Article
import com.gubee.springWithKotlin.models.Client
import com.gubee.springWithKotlin.repository.ArticleRepository
import com.gubee.springWithKotlin.repository.ClientRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(clientRepository: ClientRepository,
                            articleRepository: ArticleRepository
    ) = ApplicationRunner {

        val johnDoe = clientRepository.save(Client("johnDoe", "John", "Doe"))
        articleRepository.save(Article(
            title = "Lorem",
            headline = "Lorem",
            content = "dolor sit amet",
            author = johnDoe
        )
        )
        articleRepository.save(Article(
            title = "Ipsum",
            headline = "Ipsum",
            content = "dolor sit amet",
            author = johnDoe
        ))
    }
}