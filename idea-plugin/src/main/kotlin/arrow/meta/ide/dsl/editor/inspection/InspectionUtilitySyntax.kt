package arrow.meta.ide.dsl.editor.inspection

import arrow.meta.ide.resources.MetaIdeBundle
import org.jetbrains.kotlin.idea.util.actualsForExpected
import org.jetbrains.kotlin.idea.util.liftToExpected
import org.jetbrains.kotlin.psi.KtDeclaration

interface InspectionUtilitySyntax {
  fun KtDeclaration.withExpectedActuals(): List<KtDeclaration> {
    val expect = liftToExpected() ?: return listOf(this)
    val actuals = expect.actualsForExpected()
    return listOf(expect) + actuals
  }

  val ArrowPath: Array<String>
    get() = arrayOf(MetaIdeBundle.message("proofs.kotlin"), MetaIdeBundle.message("proofs.arrow"))

  val ProofPath: Array<String>
    get() = ArrowPath + arrayOf(MetaIdeBundle.message("proofs.type.proofs"))
}
