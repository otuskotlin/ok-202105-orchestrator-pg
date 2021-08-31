package ru.otus.otuskotlin.orchestrator.mp.transport

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.otus.otuskotlin.orchestrator.openapi.models.CreateHostRequest
import kotlin.test.Test
import kotlin.test.assertTrue

class SerializationTest {

    @Test
    fun requestSerialTest() {
        val request = CreateHostRequest(
            requestId = "12345"
        )

        val json = Json {
            prettyPrint = true
        }

        val serialString = json.encodeToString(request)
        assertTrue { serialString.contains("12345")}
    }
}