package controllers

import play.api.Configuration
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.libs.json.Json
import play.api.mvc.ControllerComponents
import play.api.test.FakeRequest
import play.api.test.Helpers._
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import io.toolsplus.atlassian.connect.play.models.PlayAddonProperties

class AppDescriptorControllerSpec extends PlaySpec with GuiceOneAppPerSuite {

  val config = Configuration.reference ++ Configuration.from(Map("addon.enableLicensing" -> true))
  val appProperties = new PlayAddonProperties(config)
  val controller = new AppDescriptorController(appProperties, config)

  val controllerComponents = app.injector.instanceOf[ControllerComponents]
  controller.setControllerComponents(controllerComponents)

  override def fakeApplication() = {
    GuiceApplicationBuilder(configuration = config).build()
  }

  "AppDescriptorController" when {

    "GET atlassian-connect.json" should {
      "render descriptor" in {
        val descriptor = controller.descriptor.apply(FakeRequest())

        status(descriptor) mustBe OK
        contentType(descriptor) mustBe Some(JSON)

        val json = Json.parse(contentAsString(descriptor))
        (json \ "key").as[String] mustBe appProperties.key
        (json \ "baseUrl").as[String] mustBe appProperties.baseUrl
        (json \ "name").as[String] mustBe config.get[String]("addon.name")
        (json \ "enableLicensing")
          .as[Boolean] mustBe config.get[Boolean]("addon.enableLicensing")
      }
    }

    "GET to base URL" should {
      "redirect to descriptor" in {
        val redirect = controller.redirectToDescriptor.apply(FakeRequest())

        redirectLocation(redirect) mustBe Some(
          routes.AppDescriptorController
            .descriptor()
            .url)
      }
    }
  }
}
