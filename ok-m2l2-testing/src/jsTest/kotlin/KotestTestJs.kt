import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class KotestTestJs: StringSpec ({
    "first Test js" {
        1.toString() shouldBe "1"
    }
})