pipeline {
  agent any
  stages {
    stage('step1') {
      steps {
        sh 'echo "step1"'
      }
    }

    stage('step2') {
      steps {
        sh 'echo "step2"'
        sh 'echo "step22"'
      }
    }

    stage('step3') {
      parallel {
        stage('step3') {
          steps {
            sh 'echo "step3"'
          }
        }

        stage('step3-1') {
          steps {
            sh 'echo "step3-1"'
          }
        }

        stage('step3-2') {
          steps {
            sh 'echo "step3-2"'
          }
        }

      }
    }

    stage('step4') {
      steps {
        sh 'echo "step4"'
      }
    }

  }
}