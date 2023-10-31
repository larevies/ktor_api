package com.example.routes
import com.example.modules.Company
import com.example.modules.companies
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.companyRouting() {
    route("/company") {
        get {
            if (companies.isNotEmpty()) {
                call.respond(companies)
            } else {
                call.respondText("No companies found", status = HttpStatusCode.OK)
            }
        }
        post {
            val company = call.receive<Company>()
            companies.add(company)
            call.respondText("Company added correctly", status = HttpStatusCode.Created)
        }
        delete("{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (companies.removeIf { it.id == id }) {
                call.respondText("Company removed correctly", status = HttpStatusCode.Accepted)
            } else {
                call.respondText("Not Found", status = HttpStatusCode.NotFound)
            }
        }
    }

}