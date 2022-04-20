pipeline {
  agent any
  tools {
        maven "maven 3.8.5"
        jdk "JDK"
    }
  stages {
    stage('Preparing to start') {
      steps {
        echo '**********Getting Ready***********'
        sh "mvn -version"
        sh "java -version"
      }
    }

    stage('Build') {
      steps {
        echo '***********Building************'
        sh "mvn clean install"
      }
    }

    stage('Test') {
      steps {
        echo '*******Testing*******'
        sh "mvn test"
      }
    }

    stage('Deploy') {
      steps {
        echo '*********Deploy*******'
      }
    }

  }
}
