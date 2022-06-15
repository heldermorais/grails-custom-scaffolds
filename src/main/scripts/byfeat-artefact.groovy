description( "Creates a Grails ByFeature artifact" ) {
    usage "grails bfeat-artifact <<ARTEFACT TYPE>> <<ARTEFACT NAME>>"
    argument name:'artefactType', description:"The type of the byFeature Artefact to be created"
    argument name:'artefactName', description:"The name of the Artefact to be created"
    flag name:'force', description:"Whether to overwrite existing files"
}

def scriptType = args[0]
def scriptName = args[1]
def model = model(scriptName)
def overwrite = flag('force') ? true : false

render  template: template("by-feature/${scriptType}.groovy"),
        destination: file("src/main/groovy/${model.packagePath}/${model.convention('Controller')}.groovy"),
        model: model,
        overwrite: overwrite