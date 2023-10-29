const disagreedRedirectLink = "https://google.com";

Disclaimer.generateDialog();

const oDisclaimer = new Disclaimer();
if (!oDisclaimer.isAccepted()) {
    oDisclaimer.loadDialog();
    oDisclaimer.centerDialog();
}

document.getElementById('agree-over21').onclick = function () {
    oDisclaimer.disableDialog();
    oDisclaimer.setAccepted();
};

document.getElementById('disagree-under21').onclick = function () {
    location.href = disagreedRedirectLink
}