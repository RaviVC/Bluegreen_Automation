pipeline {
    agent any
    stages {
        stage('validate') {
	   steps {
                echo 'validating..'
		git url: 'https://github.com/lerndevops/DevOpsClassCodes'
		bat label: '', script: 'mvn validate'
           }
        }
		stage('compile') {
	   steps {
                echo 'compiling..'
		bat label: '', script: 'mvn compile'
           }
        }
        stage('codereview-pmd') {
	   steps {
                echo 'codereview..'
		bat label: '', script: 'mvn -P metrics pmd:pmd'
           }
	   post {
               success {
                   pmd canComputeNew: false, defaultEncoding: '', healthy: '', pattern: '**/pmd.xml', unHealthy: ''
               }
           }		
        }
        stage('package') {
	   steps {
                echo 'metric-check..'
		bat label: '', script: 'mvn package'	
           }		
        }
    }
}