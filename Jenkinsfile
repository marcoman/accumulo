pipeline {
    agent any
        tools {
            jdk 'java-17-corretto'
        }
      
    stages {
        stage('Start') {
            steps {
                echo 'welcome to the build'
                sh 'whoami'
                sh 'ls ~/'
                sh 'ls ~/.ssh'
            }
        }
        stage('Checkout') {
            steps {
                echo 'checkout'
                step([$class: 'WsCleanup'])
                git branch: 'develocity-1',
                    credentialsId: 'github',
                    changelog: true,
                    url: 'git@github.com:marcoman/accumulo.git'
            }
        }
        stage('Build') {
            steps {
                echo ' mvn -B -V -e -ntp "-Dstyle.color=always" clean package dependency:resolve -DskipTests -DskipFormat -DverifyFormat -Djansi.force=true'
                sh ' mvn -B -V -e -ntp "-Dstyle.color=always" clean package dependency:resolve -DskipTests -DskipFormat -DverifyFormat -Djansi.force=true'
            }
        }
    }
}