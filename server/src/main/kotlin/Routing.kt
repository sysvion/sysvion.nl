package nl.sysvion

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.hsts.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.random.Random
import kotlinx.html.*
import org.jetbrains.exposed.sql.*
import java.time.LocalDate

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondHtml(HttpStatusCode.OK) {
                head {
                    title {
                        +"home | sysvion"
                    }
                    link { rel = "stylesheet"; href = "/static/styles.css"}
                }
                body {
                    p {
                        text("This is my,  ")
                        a {
                            href="https://github.com/sysvion"
                            target = "_blank"
                            text("sysvion")
                        }
                        text(", personal site where i'm going to host blog posts; Links to other sides;" +
                                " A portfolio of my project and contributions. And more!" +
                                " So stay tuned!")
                    }
                    h3 {+"links"}
                    p {
                        classes = setOf("heading context")
                        text("Here you can find other sites that may or may not be of interests you.")
                    }
                    div {
                        h4 {+"blogsites"}

                        p {
                            text("№56 a \"self hating\" bureaucrat ")
                            a {
                                href="https://no56.neocities.org/"
                                target = "_blank"
                                text("(neocities)")
                            }

                        }
                        p {+ "a blog about setting the envirement of a game"
                            a {
                                href = "https://riifushi-game.com/blog/"
                                target = "_blank"
                                text(
                                    "(blog)"
                                )
                            }
                        }



                    }

                }
            }
        }
        get ("/favicon.ico") {
            call.respondRedirect("/static/favicon.ico", permanent = true)
        }
        get("/date") {
            val date = LocalDate.now().toString()
            call.respondText(date)
        }

        staticResources("/static","static")
    }
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }

}
