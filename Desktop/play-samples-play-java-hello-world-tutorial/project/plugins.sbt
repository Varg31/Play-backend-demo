addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.7.3")

resolvers += "Typesafe" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += "Typesafe Simple Repository" at
  "http://repo.typesafe.com/typesafe/simple/maven-releases/"
resolvers += "Ebean" at "https://dl.bintray.com/playframework/sbt-plugin-releases"

addSbtPlugin("com.typesafe.sbt" % "sbt-play-enhancer" % "1.2.2")
