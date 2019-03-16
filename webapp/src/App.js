import React, { Component, Fragment } from "react";
import { Link , withRouter} from "react-router-dom";
import { Nav, Navbar, NavItem } from "react-bootstrap";
import { LinkContainer } from "react-router-bootstrap";
import "./App.css";
import Routes from "./Routes";
import AuthService from './services/AuthService'

class App extends Component {
  constructor(props) {
    super(props);
  
    this.state = {
      isAuthenticated: false,
      isAuthenticating: true
    };
  }
  
  userHasAuthenticated = authenticated => {
    this.setState({ isAuthenticated: authenticated });
  }
  
  handleLogout = async event => {
    await AuthService.logout();
    this.userHasAuthenticated(false);
    this.props.history.push("/login");
  }

  async componentDidMount() {
    const auth = await AuthService.isAuthenticated();
    if(auth){
      this.userHasAuthenticated(true);
    }
    this.setState({ isAuthenticating: false });
  }

  render() {
    const childProps = {
      isAuthenticated: this.state.isAuthenticated,
      userHasAuthenticated: this.userHasAuthenticated
    };
  
    return (
      !this.state.isAuthenticating &&
      <div className="App container">
        <Navbar fluid collapseOnSelect>
            <Navbar.Brand>
              <Link to="/">RMS</Link>
            </Navbar.Brand>
            <Navbar.Toggle />
           <Navbar.Collapse>
            <Nav pullRight>
              {this.state.isAuthenticated
                ? <NavItem onClick={this.handleLogout}>Logout</NavItem>
                : <Fragment>
                   {/* <LinkContainer to="/signup">
                      <NavItem>Signup</NavItem>
              </LinkContainer>  */}
                    <LinkContainer to="/login">
                      <NavItem>Login</NavItem>
                    </LinkContainer>
                  </Fragment>
              }
            </Nav>
          </Navbar.Collapse>
        </Navbar>
        <Routes childProps={childProps} />
      </div>
    );
  }
}

export default withRouter(App);

