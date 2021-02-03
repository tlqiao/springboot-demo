import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("this is first contract")
    name('basic_contract')
    request {
        method: 'GET'
        url: '/getUserDetails'
        headers {
            header("Content-Type": "application/json")
        }
    }
    response {
        status(200)
        body(["id": "100"])
    }
}