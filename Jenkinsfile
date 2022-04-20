pipeline {
  agent any
  stages {
    stage('Preparing to start') {
      parallel {
        stage('Preparing to start') {
          steps {
            echo '**********Getting Ready***********'
            sh 'mvn -version'
            sh 'java -version'
          }
        }

        stage('Just Branchin') {
          steps {
            echo 'branching out'
          }
        }

        stage('Maven Version') {
          steps {
            sh 'sh "mvn --version"'
          }
        }

      }
    }

    stage('Build') {
      steps {
        echo '***********Building************'
        sh 'mvn clean install'
      }
    }

    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            echo '*******Testing*******'
            sh 'mvn test'
            junit 'target/**/*.xml'
          }
        }

        stage('') {
          steps {
            timeout(time: 90) {
              echo 'Performance testing complete'
            }

          }
        }

      }
    }

    stage('Deploy') {
      steps {
        echo '*********Deploy*******'
      }
    }

  }
  tools {
    maven 'maven 3.8.5'
    jdk 'JDK'
  }
}