package controllers

import com.google.inject.Inject
import io.toolsplus.atlassian.connect.play.actions.AtlassianHostUserAction
import play.api.Environment
import play.api.Mode.Dev
import play.api.mvc.InjectedController

class AppIframeController @Inject()(
    assetFinder: AssetsFinder,
    atlassianHostUserAction: AtlassianHostUserAction,
    environment: Environment)
    extends InjectedController {

  import atlassianHostUserAction.Implicits._

  /** Renders a Atlassian Connect iframe and bootstrapping
    * a Javascript application (e.g. React with AtlasKit).
    *
    * @param title Iframe title
    * @param entry Entry point of the Javascript application
    * @return Rendered iframe
    */
  def iframe(title: String, entry: String) =
    atlassianHostUserAction { implicit request =>
      Ok(views.html.iframe(title, entry, assetFinder, environment.mode == Dev))
    }
}
