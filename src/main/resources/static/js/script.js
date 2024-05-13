console.log("script loading....");

const changeTheme = () => {
  // set to web page
  document.querySelector("html").classList.add(currentTheme);
  // set the listener to change theme button
  document.querySelector("#theme").addEventListener("click", (event) => {
    console.log("Button clicked");
    document.querySelector("html").classList.remove(currentTheme);
    if (currentTheme === "dark") {
      // theme will be light
      currentTheme = "light";
    } else {
      currentTheme = "dark";
    }

    // update on localstorage
    setTheme(currentTheme);
    document.querySelector("html").classList.add(currentTheme);
  });
};

// set theme to localstorage
const setTheme = (theme) => {
  localStorage.setItem("theme", theme);
};

// get theme to localstorage
const getTheme = () => {
  let theme = localStorage.getItem("theme");
  if (theme) return theme;
  else return "light";
};

let currentTheme = getTheme();

// initial --->
changeTheme(currentTheme);
