pipeline {
  agent any
  stages {
    stage('Getting ready') {
      steps {
        echo 'About to build'
      }
    }

    stage('Maven') {
      steps {
        sh 'mvn clean install'
        sh 'mvn spring-boot:run'
      }
    }

  }
}