var dropdownMenuCar = document.querySelector('.dropdown-menu-c');
var dropdownMenuPS = document.querySelector('.dropdown-menu-ps');
var dropdownMenuPL = document.querySelector('.dropdown-menu-pl');

// Get the link that opens the dropdown menu
var dropdownLink_c = document.querySelector('.dropdown-c a');
var dropdownLink_ps = document.querySelector('.dropdown-ps a');
var dropdownLink_pl = document.querySelector('.dropdown-pl a');

// Add a click event listener to the dropdown link
dropdownLink_c.addEventListener('click', function(event) {
  // Prevent the default link behavior
  event.preventDefault();

  // If the dropdown menu is already visible, hide it
  if (dropdownMenuCar.style.display === 'block') {
    dropdownMenuCar.style.display = 'none';
  } else {
    // Otherwise, show the dropdown menu
    dropdownMenuCar.style.display = 'block';
    
  }
});

dropdownLink_ps.addEventListener('click', function(event) {
  // Prevent the default link behavior
  event.preventDefault();

  // If the dropdown menu is already visible, hide it
  if (dropdownMenuPS.style.display === 'block') {
    dropdownMenuPS.style.display = 'none';
  } else {
    // Otherwise, show the dropdown menu
    dropdownMenuPS.style.display = 'block';
    
  }
});

dropdownLink_pl.addEventListener('click', function(event) {
  // Prevent the default link behavior
  event.preventDefault();

  // If the dropdown menu is already visible, hide it
  if (dropdownMenuPL.style.display === 'block') {
    dropdownMenuPL.style.display = 'none';
  } else {
    // Otherwise, show the dropdown menu
    dropdownMenuPL.style.display = 'block';
    
  }
});

const dropdown_c = document.querySelector('.dropdown-c');
const dropdown_ps = document.querySelector('.dropdown-ps');
const dropdown_pl = document.querySelector('.dropdown-pl');
const menuC = document.querySelector('.dropdown-menu-c');
const menuPS = document.querySelector('.dropdown-menu-ps');
const menuPL = document.querySelector('.dropdown-menu-pl');
const content = document.querySelector('.container');

dropdown_c.addEventListener('click', function() {
  menuC.classList.add('show');
  const menuHeight = menuC.offsetHeight;
  content.style.marginTop = menuHeight + 'px';
});

dropdown_ps.addEventListener('click', function() {
  menuPS.classList.add('show');
  const menuHeight = menuPS.offsetHeight;
  content.style.marginTop = menuHeight + 'px';
});

dropdown_pl.addEventListener('click', function() {
  menuPL.classList.add('show');
  const menuHeight = menuPL.offsetHeight;
  content.style.marginTop = menuHeight + 'px';
});