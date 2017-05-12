String francais = new File('francais.properties').getText('UTF-8')
def propsFrancais = new Properties()
propsFrancais.load(new StringReader(francais))

String anglais = new File('english.properties').getText('UTF-8')
def propsAnglais = new Properties()
propsAnglais.load(new StringReader(anglais))

def template = new File('template.html').getText('UTF-8')
def engine = new groovy.text.SimpleTemplateEngine()
def accueil = engine.createTemplate(template).make(propsFrancais).toString()
def welcome = engine.createTemplate(template).make(propsAnglais).toString()

new File('index.html').setText(accueil, 'UTF-8');
new File('welcome.html').setText(welcome, 'UTF-8');