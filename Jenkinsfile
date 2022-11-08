pipeline {
    agent {
          docker {
              image 'maven:3.8.3-openjdk-17'
              args '-p 33333:8095'
          }
     }

    // docker.image('maven:3.8.3-openjdk-17').withRun("-p 33333:8095").inside {
    //         sh 'mvn --version'
    //     }

     environment {
          HOME = '.'
     }
     stages {
          stage('Source') {
              steps {
                //   script {
                //       docker.image('maven:3.8.3-openjdk-17').run('-p 33333:8095')
                //   }
    // agent {
    //       docker {
    //           image 'maven:3.8.3-openjdk-17'
    //           args '-p 33333:8095'
    //       }
    //  }

                    git branch: 'dev',
                        url: 'https://github.com/angeldashbaby/database'
               }
          }
          stage('Build') {
               steps {
                    sh 'mvn package -DskipTests'
               }
          }
          stage('Test') {
               steps {
                    echo 'testing...'
               }
          }
          stage('Deploy') {
               steps {
                //   script {
                //       docker.image('mysql').run('--name=angelbaby_db -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=angelbaby_db -p 3309:3306 -d')
                //   }
        //                 agent {
        //   docker {
        //       image 'mysql'
        //       args '--name=angelbaby_db -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=angelbaby_db -p 3309:3306 -d'
        //   }
    //  }
                //   sh 'docker --name=angelbaby_db -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=angelbaby_db -p 3309:3306 -d mysql'
                    sh 'java -jar ./target/database-0.0.1-SNAPSHOT.jar'

               }
          }
     }
}