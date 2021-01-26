import React, { Component } from "react";
import { NavBarStudent } from "./NavBarHome";
import { connect } from "react-redux";
import * as actionCreators from "../actions/action";
import axios from "axios";

class UpdateStudentProfile extends Component {
  constructor(props) {
    super(props);

    this.state = {
      firstName: "",
      middleName: "",
      lastName: "",
      contactNo: "",
      emailId: "",
      studentObj: {},
    };
    // this.updateProfile = this.updateProfile.bind(this);
    // this.showDetails = this.showDetails.bind(this);
  }
  componentWillMount() {
    if (!localStorage.getItem("loggedUser")) {
      this.props.history.replace("/student-login");
    }
  }

  inputEvent = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    this.setState({ [name]: value });
  };

  componentDidMount() {
    const loggedUserObject = JSON.parse(localStorage.getItem("loggedUser"));
    const loggedUserId = loggedUserObject.studentId;
    this.props.onGetSingleStudentDetails(loggedUserId);
  }

  updateProfile = (e) => {
    const loggedUserObject = JSON.parse(localStorage.getItem("loggedUser"));
    const loggedUserId = loggedUserObject.studentId;
  };

  render() {
    return (
      <div className="container-fluid">
        <NavBarStudent />

        <form onSubmit={this.updateProfile}>
          <div
            className="form-group cname"
            style={{ textAlign: "center", marginTop: "80px" }}
          >
            <input
              className="form-control"
              type="text"
              id="studentFirstName"
              name="firstName"
              onChange={this.inputEvent}
              placeholder={this.props.studentObj.firstName}
              required
            />
            <br />

            <input
              className="form-control"
              type="text"
              id="studentMiddleName"
              name="middleName"
              onChange={this.inputEvent}
              placeholder={this.props.studentObj.middleName}
              required
            />
            <br />

            <input
              className="form-control"
              type="text"
              id="studentLastName"
              name="lastName"
              onChange={this.inputEvent}
              placeholder={this.props.studentObj.lastName}
              required
            />
            <br />

            <input
              className="form-control"
              type="text"
              id="studentEmailId"
              name="emailId"
              onChange={this.inputEvent}
              placeholder={this.props.studentObj.emailId}
              required
            />
            <br />

            <input
              className="form-control"
              type="text"
              id="studentContactNo"
              name="contactNo"
              onChange={this.inputEvent}
              placeholder={this.props.studentObj.contactNumber}
              required
            />

            <br />
            <button type="submit" id="trainer-button">
              Update Profile
            </button>
          </div>
        </form>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  console.log(state);
  // console.log(state.studentObj + "hello how do you do");
  return {
    studentObj: state.studentObj,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    onGetSingleStudentDetails: (id) => {
      return dispatch(actionCreators.getSingleStudentDetails(id));
    },
    clearState: () => {
      dispatch(actionCreators.clearState());
    },
  };
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(UpdateStudentProfile);
