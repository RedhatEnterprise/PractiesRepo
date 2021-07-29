properties([
	parameters([[
		$class: 'PT_SINGLE_SELECT', 
			choiceType: 'PT_CHECKBOX', 
			filterLength: 1, 
			filterable: false, 
			name: 'Env', 
			randomName: 'choice-parameter-16065095693972', 
			script: [
				$class: 'GroovyScript', 
				fallbackScript: [
					classpath: [], 
					sandbox: false, 
					script: 
					'return { "Please Select Env" }'], 
					script: [
						classpath: [], 
						sandbox: true, 
						script: 
							'''return {
								"PROD"
								"QA"
								"DEV"
								}'''
							]
				]
			], 
			[$class: 'CascadeChoiceParameter', 
				choiceType: 'PT_SINGLE_SELECT', 
				filterLength: 1, filterable: false,
				name: 'SubEnv', 
				randomName: 'choice-parameter-16065105513321', 
				referencedParameters: 'Env', 
				script: [
					$class: 'GroovyScript', 
					fallbackScript: [
						classpath: [], 
						sandbox: false, 
						script: 
							'return ["Please select sub env"]'], 
							script: [
								classpath: [], 
								sandbox: true, 
								script: 
								'''if (Env.equals("PROD")) {
										return ["PROD1", "PROD2"]
										}
										else if (Env.equals("QA")) {
										return  ["QA1"]
										}
										else if (Env.equals("DEV")) {
										return ["DEV1", "DEV2"]
										}
								'''
							]
				]
			], 
			[$class: 'CascadeChoiceParameter', 
				choiceType: 'PT_SINGLE_SELECT', 
				filterLength: 1, 
				filterable: false, 
				name: 'ServerName', 
				randomName: 'choice-parameter-16065113536078', 
				referencedParameters: 'SubEnv', 
				script: [
					$class: 'GroovyScript',
					fallbackScript: [
						classpath: [], 
						sandbox: false, 
						script: 
							'return ["Please Select ServerName"]'], 
							script: [
								classpath: [], 
								sandbox: true, 
								script: 
									'''if (SubEnv.equals("PROD1")) {
											return ["palnx01", "palnx02", "palnx03"] 
										 }
										else if (SubEnv.equals("PROD2")) {
											   return ["pblnx01", "pblnx02"]
										 }
										else if (SubEnv.equals("QA1"))  {
											   return  ["qalnx01"] 
										}
										else if (SubEnv.equals ("DEV1")) {
											   return ["dalnx01", "dalnx02"] 
										}
										else if (SubEnv.equals("DEV2")) {
											  return ["dblnx01"]
										}

									'''
							]
				]
			]
	])
])
