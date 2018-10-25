package controllers

import com.google.inject.Inject
import io.toolsplus.atlassian.connect.play.api.models.AppProperties
import play.api.Configuration
import play.api.mvc.InjectedController

class AppDescriptorController @Inject()(appProperties: AppProperties,
                                        configuration: Configuration)
    extends InjectedController {

  /** Renders the JSON descriptor.
    *
    * @return Rendered JSON descriptor
    */
  def descriptor = Action {
    val enableLicensing = configuration.get[Boolean]("addon.enableLicensing")
    Ok(
      views.json.descriptor(appProperties.key,
                            appProperties.name,
                            appProperties.baseUrl,
                            enableLicensing)).as(JSON)
  }

  /** Redirects request to the add-on descriptor.
    *
    * This is useful to easily redirect specific routes to the add-on descriptor.
    *
    * @return Rendered JSON descriptor.
    */
  def redirectToDescriptor =
    Action(Redirect(routes.AppDescriptorController.descriptor()))

}
