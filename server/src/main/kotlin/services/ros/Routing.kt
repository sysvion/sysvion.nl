package services.ros
import io.ktor.http.HttpStatusCode
import io.ktor.server.html.respondHtml
import io.ktor.server.response.respondText
import io.ktor.server.routing.*
import kotlinx.html.*

fun Route.ros() {
    get() {
        call.respondHtml {
            head {
                title { + "Ros 2 Tutorial"}
                link { rel = "stylesheet"; href = "/static/styles.css" }

            }
            body {
                h1 {
                    + "ROS 2 quickstart tutorial"
                }

                p {
                    + "WARNING: This is still a work in process."
                }

                p {
                    + "Learn what ROS 2 can provide with a vm and control real robots!"
                }

                p {
                    +"This project is created for the "
                    a {
                        href="https://robotminor.nl"
                        target="_blank"
                        +"robot minor"
                    }
                    + " by a student from the robot minor of the semester 2025-2026 Q4. And year on year be maintained. "
                    + "Last time i checked this project. <offline>"
                }

                h2 {
                    + "Course summary and requirements"
                }

                p {
                    + "You will learn what a ros2 node is and how to set one up using python. "
                    + "Then you take a video stream from a webcam and move the robot so it follows your hand."
                }

                p {
                    + "I assume you have spend around a week programming in python and opencv. And you know hove to use the linux terminal."
                }

                ul {
                    li {
                        +"X86_64 computer that runs VirtualBox"
                    }
                    li {
                        + "20 gb free space"
                    }
                    li {
                        + "at least 6 gb of free ram"
                    }
                }
                img {
                    src="/static/vbox_buttons.png"
                }

                p {
                    + "You import the vm image by pressing the open button. Then you want to spam next."
                }

                button {
                    onClick="window.location.href='"+ call.route.parent!!.path+"/jazzy/ros2-tutorial-vm-x64.vbi'"
                    + "Download disk image"
                }


                p {
                    + "The tutorial will be baked in the virtual machine image in form of markdown files that are designed to be viewed in vscode. "
                    + "When you start the vm please open vscode."
                }
                
            }
        }

    }

    get("/jazzy/ros2-tutorial-vm-x64.vbi") {
        call.respondText("TODO", status = HttpStatusCode.NotImplemented)
    }
}
