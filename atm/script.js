const baseUrl = "http://localhost:8080/api/user";

function register() {
  const card = document.getElementById("regCard").value;
  const pin = document.getElementById("regPin").value;

  fetch(`${baseUrl}/register?cardNumber=${card}&pin=${pin}`, { method: "POST" })
    .then(res => res.text())
    .then(msg => document.getElementById("regMsg").innerText = msg);
}

function login() {
  const card = document.getElementById("loginCard").value;
  const pin = document.getElementById("loginPin").value;

  fetch(`${baseUrl}/login?cardNumber=${card}&pin=${pin}`, { method: "POST" })
    .then(res => res.text())
    .then(msg => document.getElementById("loginMsg").innerText = msg);
}

function checkBalance() {
  const card = document.getElementById("balCard").value;

  fetch(`${baseUrl}/balance?cardNumber=${card}`)
    .then(res => res.text())
    .then(msg => document.getElementById("balMsg").innerText = msg);
}

function deposit() {
  const card = document.getElementById("depCard").value;
  const amt = document.getElementById("depAmt").value;

  fetch(`${baseUrl}/deposit?cardNumber=${card}&amount=${amt}`, { method: "POST" })
    .then(res => res.text())
    .then(msg => document.getElementById("depMsg").innerText = msg);
}

function withdraw() {
  const card = document.getElementById("withCard").value;
  const amt = document.getElementById("withAmt").value;

  fetch(`${baseUrl}/withdraw?cardNumber=${card}&amount=${amt}`, { method: "POST" })
    .then(res => res.text())
    .then(msg => document.getElementById("withMsg").innerText = msg);
}

function getTransactions() {
  const card = document.getElementById("txnCard").value;

  fetch(`${baseUrl}/transactions?cardNumber=${card}`)
    .then(res => res.json())
    .then(data => {
      const list = document.getElementById("txnList");
      list.innerHTML = "";
      data.forEach(txn => {
        const item = document.createElement("li");
        item.innerText = `${txn.type} of ₹${txn.amount} on ${txn.timestamp}`;
        list.appendChild(item);
      });
    });
}
