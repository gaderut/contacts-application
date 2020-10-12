<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>App</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>var context = '${context}';
    </script>
</head>
<body>
<div class="container" ng-app="sample" ng-controller="viewUserController as vController" ng-init="beforeLoad()">
    <h2>Contact List Application</h2>
    <div class="panel panel-default">
        <div class="panel-heading"><h2>All Contacts</h2></div>

        <div class="panel-body">
            <a data-toggle="modal" data-target="#addUser" class="pull-right btn btn-sm btn-success">Add New Contact </a>
            <br>
            <br>
         	<form ng-submit="viewUser.getAllUserContactSearch(user.fname)">
         		<div class="form-group">
                                <label for="fname">Search by anything: </label>
                                <input type="text" ng-model="user.fname" required class="form-control" id="fname">
                </div>
                <button type="submit" class="pull-right btn btn-warning btn-sm">Search</button> 
         	</form>	
            
            <table class="table">
                <thead>
                <tr>
                    <th>Contacts</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                <tr ng-repeat="user in users">
                    <td>{{user.fname}} {{user.lname}}</td>
                    <td>
                        <a class="btn btn-info btn-sm" ng-click="viewUser.getAllUserContact(user.id,user.fname)">View
                        Contact Details</a>
                        <a data-toggle="modal" data-target="#editUser" ng-click="viewUser.getAllUserContact(user.id,user.fname)" class="btn btn-warning btn-sm">Edit</a>
                        <a class="btn btn-danger btn-sm" ng-click="deleteUser.delete(user.id,user.fname)">Delete</a>
                    </td>
                </tr>
                </tr>
                </tbody>
            </table>
            <br>

            <div class="row">
                <center>
                    <h3>{{userDec}}</h3>
                    <table class="table" ng-if="contacts != null">
                        <thead>
                        <tr>
                            <th>First Name</th>
                            <th>Middle Name</th>
                            <th>Last Name</th>
                            <th>Address Type</th>
                            <th>Address</th>
                            <th>City</th>
                            <th>State</th>
                            <th>Zip</th>
                            <th>Address Type</th>
                            <th>Address</th>
                            <th>City</th>
                            <th>State</th>
                            <th>Zip</th>
                            <th>Phone Type</th>
                            <th>Phone Number</th>
                            <th>Phone Type</th>
                            <th>Phone Number</th>
                            <th>Date Type</th>
                            <th>Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr ng-repeat="contact in contacts">
                            <td>{{ contact.fname }}</td>
                            <td>{{ contact.mname }}</td>
                            <td>{{ contact.lname }}</td>
                            <td>{{ contact.address_type1 }}</td>
                            <td>{{ contact.address1 }}</td>
                            <td>{{ contact.city1 }}</td>
                            <td>{{ contact.state1 }}</td>
                            <td>{{ contact.zip1 }}</td>
                            <td>{{ contact.address_type2 }}</td>
                            <td>{{ contact.address2 }}</td>
                            <td>{{ contact.city2 }}</td>
                            <td>{{ contact.state2 }}</td>
                            <td>{{ contact.zip2 }}</td>
                            <td>{{ contact.phone_type1 }}</td>
                            <td>{{ contact.phone1 }}</td>
                            <td>{{ contact.phone_type2 }}</td>
                            <td>{{ contact.phone2 }}</td>
                            <td>{{ contact.date_type }}</td>
                            <td>{{ contact.date_full }}</td>
                        </tr>
                        </tbody>
                    </table>
                </center>
            </div>


        </div>


        <!-- Modal -->
        <div class="modal fade" id="addUser" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header bg-success">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">New Contact</h4>
                    </div>
                    <div class="modal-body">
                        <h2>Contact Details to be saved</h2>
                        <form ng-submit="addUser.addUser()">
                            <div class="form-group">
                                <label for="fname">First Name:</label>
                                <input type="text" ng-model="user.fname" required class="form-control" id="fname">
                            </div>
                            <div class="form-group">
                                <label for="mname">Middle Name:</label>
                                <input type="text" ng-model="user.mname" class="form-control" id="mname">
                            </div>
                            <div class="form-group">
                                <label for="lname">Last Name:</label>
                                <input type="text" ng-model="user.lname" class="form-control" id="lname">
                            </div>
    						 <div class="form-group">
                                <label for="address_type1">Address Type</label>
                                <input type="text" ng-model="user.address_type1" class="form-control" id="address_type1">
                            </div>
                            <div class="form-group">
                                <label for="address1">Address</label>
                                <input type="text" ng-model="user.address1" class="form-control" id="address1">
                            </div>
                            <div class="form-group">
                                <label for="city1">City</label>
                                <input type="text" ng-model="user.city1" class="form-control" id="city1">
                            </div>
                            <div class="form-group">
                                <label for="state1">State</label>
                                <input type="text" ng-model="user.state1" class="form-control" id="state1">
                            </div>
                            <div class="form-group">
                                <label for="zip1">Zip</label>
                                <input type="text" ng-model="user.zip1" class="form-control" id="zip1">
                            </div>
                            <div class="form-group">
                                <label for="address_type2">Address Type</label>
                                <input type="text" ng-model="user.address_type2" class="form-control" id="address_type2">
                            </div>
                            <div class="form-group">
                                <label for="address2">Address</label>
                                <input type="text" ng-model="user.address2" class="form-control" id="address2">
                            </div>
                            <div class="form-group">
                                <label for="city2">City</label>
                                <input type="text" ng-model="user.city2" class="form-control" id="city2">
                            </div>
                            <div class="form-group">
                                <label for="state2">State</label>
                                <input type="text" ng-model="user.state2" class="form-control" id="state2">
                            </div>
                            <div class="form-group">
                                <label for="zip2">Zip</label>
                                <input type="text" ng-model="user.zip2" class="form-control" id="zip2">
                            </div>
                            <div class="form-group">
                                <label for="phone_type1">Phone Type</label>
                                <input type="text" ng-model="user.phone_type1" class="form-control" id="phone_type1">
                            </div>
                            <div class="form-group">
                                <label for="phone1">Phone Number</label>
                                <input type="text" ng-model="user.phone1" class="form-control" id="phone1">
                            </div>
                            <div class="form-group">
                                <label for="phone_type2">Phone Type</label>
                                <input type="text" ng-model="user.phone_type2" class="form-control" id="phone_type2">
                            </div>
                            <div class="form-group">
                                <label for="phone2">Phone Number</label>
                                <input type="text" ng-model="user.phone2" class="form-control" id="phone2">
                            </div>
                            <div class="form-group">
                                <label for="date_type">Date Type</label>
                                <input type="text" ng-model="user.date_type" class="form-control" id="date_type">
                            </div>
                            <div class="form-group">
                                <label for="date_full">Date</label>
                                <input type="date" ng-model="user.date_full" class="form-control" id="date_full">
                            </div> 
                            <br>
                            <br>

                            <button type="submit" class="pull-right btn btn-default">Save</button>
                            <br>
                            <br>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
		
		<!-- Modal -->
        <div class="modal fade" id="editUser" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header bg-success">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Edit Contact</h4>
                    </div>
                    <div class="modal-body">
                        <h2>Make the changes in the details</h2>
                        <form ng-submit="editUser.edit()" ng-repeat="contact in contacts">
                            <div class="form-group">
                                <label for="fname">First Name:</label>
                                <input type="text" ng-model="contact.fname" required class="form-control" id="fname">
                            </div>
                            <div class="form-group">
                                <label for="mname">Middle Name:</label>
                                <input type="text" ng-model="contact.mname" class="form-control" id="mname">
                            </div>

                            <div class="form-group">
                                <label for="lname">Last Name:</label>
                                <input type="text" ng-model="contact.lname" class="form-control" id="lname">
                            </div>
    						<div class="form-group">
                                <label for="address_type1">Address Type</label>
                                <input type="text" ng-model="contact.address_type1" class="form-control" id="address_type1">
                            </div>
                            <div class="form-group">
                                <label for="address1">Address</label>
                                <input type="text" ng-model="contact.address1" class="form-control" id="address1">
                            </div>
                            <div class="form-group">
                                <label for="city1">City</label>
                                <input type="text" ng-model="contact.city1" class="form-control" id="city1">
                            </div>
                            <div class="form-group">
                                <label for="state1">State</label>
                                <input type="text" ng-model="contact.state1" class="form-control" id="state1">
                            </div>
                            <div class="form-group">
                                <label for="zip1">Zip</label>
                                <input type="text" ng-model="contact.zip1" class="form-control" id="zip1">
                            </div>
                            <div class="form-group">
                                <label for="address_type2">Address Type</label>
                                <input type="text" ng-model="contact.address_type2" class="form-control" id="address_type2">
                            </div>
                            <div class="form-group">
                                <label for="address2">Address</label>
                                <input type="text" ng-model="contact.address2" class="form-control" id="address2">
                            </div>
                            <div class="form-group">
                                <label for="city2">City</label>
                                <input type="text" ng-model="contact.city2" class="form-control" id="city2">
                            </div>
                            <div class="form-group">
                                <label for="state2">State</label>
                                <input type="text" ng-model="contact.state2" class="form-control" id="state2">
                            </div>
                            <div class="form-group">
                                <label for="zip2">Zip</label>
                                <input type="text" ng-model="contact.zip2" class="form-control" id="zip2">
                            </div>
                            <div class="form-group">
                                <label for="phone_type1">Phone Type</label>
                                <input type="text" ng-model="contact.phone_type1" class="form-control" id="phone_type1">
                            </div>
                            <div class="form-group">
                                <label for="phone1">Phone Number</label>
                                <input type="text" ng-model="contact.phone1" class="form-control" id="phone1">
                            </div>
                            <div class="form-group">
                                <label for="phone_type2">Phone Type</label>
                                <input type="text" ng-model="contact.phone_type2" class="form-control" id="phone_type2">
                            </div>
                            <div class="form-group">
                                <label for="phone2">Phone Number</label>
                                <input type="text" ng-model="contact.phone2" class="form-control" id="phone2">
                            </div>
                            <div class="form-group">
                                <label for="date_type">Date Type</label>
                                <input type="text" ng-model="contact.date_type" class="form-control" id="date_type">
                            </div>
                            <div class="form-group">
                                <label for="date_full">Date</label>
                                <input type="date" ng-model="contact.date_full" class="form-control" id="date_full">
                            </div> 
                            <br>
                            <br>

                            <button type="submit" class="pull-right btn btn-default">Edit</button>
                            <br>
                            <br>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<script>
    var sample = angular.module('sample', []);
    sample.controller('viewUserController', ['$scope', '$http', function ($scope, $http) {

        $scope.users, $scope.userDec, $scope.contacts = null;
        $scope.user = {
            sampleContactCollection: [
                {
                    contact: null,
                }
            ]
        };
        $scope.beforeLoad = function () {
            $scope.viewUser.getAllUsers();
        }
        $scope.viewUser = {
            getAllUsers: function () {
                $http({
                    method: 'GET',
                    url: context + '/user/get',
                }).then(function successCallback(response) {
                    if (response.status == 400) {
                        alert('Users Not Found');
                    } else if (response.status == 200) {
                        $scope.users = response.data;
                    }
                }, function errorCallback(response) {
                    alert(JSON.stringify(response));
                });
            },
            getAllUserContact: function (id, name) {
                $http({
                    method: 'GET',
                    url: context + '/user/get/contact',
                    params: {id: id}
                }).then(function successCallback(response) {
                    if (response.status == 204) {
                        $scope.userDec = "Contacts details not there";
                        $scope.contacts = null;
                    } else if (response.status == 200) {
                        $scope.userDec = "Contact Display Window";
                        $scope.contacts = response.data;
                    }
                }, function errorCallback(response) {
                    alert(JSON.stringify(response));
                });
            },
            getAllUserContactSearch: function (name) {
                $http({
                    method: 'GET',
                    url: context + '/user/get/search',
                    params: {name: name}
                }).then(function successCallback(response) {
                    if (response.status == 204) {
                        $scope.users = null;
                    } else if (response.status == 200) {
                        $scope.users = response.data;
                    }
                }, function errorCallback(response) {
                    alert(JSON.stringify(response));
                });
            }
        }

        $scope.addUser = {
            addUser: function () {
                $http({
                    method: 'POST',
                    url: context + '/user/add',
                    data : $scope.user
                }).then(function successCallback(response) {
                    if (response.status == 204) {

                    } else if (response.status == 200) {
                        $scope.user = {
                            sampleContactCollection: [
                                {
                                    contact: null,
                                }
                            ]
                        };
                        alert(response.data.message);
                        $scope.viewUser.getAllUsers();
                    }
                }, function errorCallback(response) {
                    alert(JSON.stringify(response));
                });

            }
        }

        $scope.deleteUser = {
            delete: function (id,fname) {

                $http({
                    method: 'DELETE',
                    url: context + '/user/delete/'+id
                }).then(function successCallback(response) {
                    if (response.status == 204) {
                        //fail message
                    } else if (response.status == 200) {
                        alert(fname+' '+response.data.message);
                        $scope.viewUser.getAllUsers();
                        $scope.contacts = null;
                    }
                }, function errorCallback(response) {
                    alert(JSON.stringify(response));
                });

            }
        }

                
        $scope.editUser = {
                edit: function () {
                    $http({
                        method: 'PUT',
                        url: context + '/user/edit',
                        data : $scope.contacts
                    }).then(function successCallback(response) {
                        if (response.status == 204) {

                        } else if (response.status == 200) {
                            $scope.user = {
                                sampleContactCollection: [
                                    {
                                        contact: null,
                                    }
                                ]
                            };
                            alert(response.data.message);
                            $scope.viewUser.getAllUsers();
                        }
                    }, function errorCallback(response) {
                        alert(JSON.stringify(response));
                    });

                }
            }
        
    }])
    ;
</script>

</body>
</html>

