pipeline {
  agent any
  tools {
        maven "maven 3.8.5"
    }
  stages {
    stage('Preparing to start') {
      steps {
        echo '**********Getting Ready***********'
      }
    }

    stage('Build') {
      steps {
        echo '***********Building************'
      }
    }

    stage('Test') {
      steps {
        echo '*******Testing*******'
      }
    }

    stage('Deploy') {
      steps {
        echo '*********Deploy*******'
      }
    }

  }
}
