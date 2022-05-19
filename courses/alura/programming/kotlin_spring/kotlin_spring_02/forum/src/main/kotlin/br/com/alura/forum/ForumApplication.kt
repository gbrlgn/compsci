package br.com.alura.forum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableCaching
class ForumApplication

fun main(args: Array<String>) {
	runApplication<ForumApplication>(*args)
}