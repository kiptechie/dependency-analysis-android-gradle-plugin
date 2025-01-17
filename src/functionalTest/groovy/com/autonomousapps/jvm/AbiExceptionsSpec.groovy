package com.autonomousapps.jvm

import com.autonomousapps.jvm.projects.AbiExceptionsProject

import static com.autonomousapps.utils.Runner.build
import static com.google.common.truth.Truth.assertThat

final class AbiExceptionsSpec extends AbstractJvmSpec {

  def "declared exceptions are part of the abi (#gradleVersion)"() {
    given:
    def project = new AbiExceptionsProject()
    gradleProject = project.gradleProject

    when:
    build(gradleVersion, gradleProject.rootDir, 'buildHealth')

    then:
    assertThat(project.actualBuildHealth()).containsExactlyElementsIn(project.expectedBuildHealth)

    where:
    gradleVersion << gradleVersions()
  }
}
