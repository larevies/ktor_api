package com.example

import com.example.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("our super cool and unfinished http api!", bodyAsText())
        }
    }

    @Test
    fun testHelp() = testApplication {
        application {
            configuteConnection()
        }
        client.get("/help").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("[]", bodyAsText())
        }
    }
}
