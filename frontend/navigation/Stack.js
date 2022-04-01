import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import { Button, Image, TouchableOpacity } from 'react-native';

import Tabs from './tabs';
import SignIn from '../screens/SignIn';
import SignUp from '../screens/SignUp';

import Home from '../screens/Home';
import Profile from '../screens/Profile';
import MyArticles from '../screens/MyArticles';
import Course from '../screens/Course';
import CourseDetail from '../screens/CourseDetail';
import MyComments from '../screens/MyComments';
import MyReviews from '../screens/MyReviews';
import MyRecords from '../screens/MyRecords';
import MyInfo from '../screens/MyInfo';
import LogoTitle from '../components/Header/LogoTitle';
import ProfileIcon from '../assets/icons/ProfileIcon.jpg';
import 'react-native-gesture-handler';

<<<<<<< HEAD
=======
import UpdatePage  from '../screens/UpdatePage';
>>>>>>> 40f2acd529ad2f186800b9064e3d6404fe64de38
import CommunityDetail from '../screens/CommunityDetail';
import CommunityBoard from '../screens/CommunityBoard';
import Community from '../screens/Community';
import WritePage from '../screens/WritePage';

import ChatDetail from '../screens/ChatDetail';
import ChatList from '../screens/ChatList';

const HomeStack = createStackNavigator();
const HomeScreen = () => {
  return (
    <HomeStack.Navigator
      initialRouteName="Home"
      screenOptions={{
        cardStyle: { backgroundColor: '#ffffff' },
      }}>
      <Stack.Screen
        name="Home"
        component={Home}
        options={({ navigation }) => ({
          headerTitle: props => <LogoTitle {...props} />,
          headerTitleStyle: { flex: 1 },
          headerBackTitleVisible: false,
          headerLeft: null,
          headerRight: () => (
            <TouchableOpacity
              onPress={() => navigation.navigate('Profile')}
              style={{ marginRight: '13%' }}>
              <Image
                source={ProfileIcon}
                style={{ width: 20, height: 28, marginBottom: '3%' }}
              />
            </TouchableOpacity>
          ),
        })}
      />
      <Stack.Screen name="Profile" component={Profile} />
      <Stack.Screen name="MyArticles" component={MyArticles} />
      <Stack.Screen name="MyComments" component={MyComments} />
      <Stack.Screen name="MyReviews" component={MyReviews} />
      <Stack.Screen name="MyRecords" component={MyRecords} />
      <Stack.Screen name="MyInfo" component={MyInfo} />
    </HomeStack.Navigator>
  );
};

const CommunityStack = createStackNavigator();
const CommunityScreen = () => {
  return (
    <CommunityStack.Navigator screenOptions={{ headerShown : false }} initialRouteName='Community'>
      <Stack.Screen name="Community" component={Community}/>
      <Stack.Screen name="CommunityBoard" component={CommunityBoard}/>
      <Stack.Screen name="CommunityDetail" component={CommunityDetail}/>
      <Stack.Screen name="WritePage" component={WritePage} />
      <Stack.Screen name="UpdatePage" component={UpdatePage} />
    </CommunityStack.Navigator>
  );
};
const CourseStack = createStackNavigator();
const CourseScreen = () => {
  return (
    <CourseStack.Navigator screenOptions={{ headerShown: false }}>
      <Stack.Screen name="Course" component={Course} />
      <Stack.Screen name="CourseDetail" component={CourseDetail} />
    </CourseStack.Navigator>
  );
};

const ChatStack = createStackNavigator();
const ChatScreen = () => {
  return (
    <ChatStack.Navigator>
      <Stack.Screen name="ChatList" component={ChatList} />
      <Stack.Screen name="ChatDetail" component={ChatDetail} />
    </ChatStack.Navigator>
  )
}

const Stack = createStackNavigator();
const StackNavigation = () => {
  return (
    <Stack.Navigator
      screenOptions={{
        headerShown: false,
        cardStyle: { backgroundColor: '#ffffff' },
      }}>
      <Stack.Screen name="SignIn" component={SignIn} />
      <Stack.Screen name="SignUp" component={SignUp} />
      <Stack.Screen name="Tabs" component={Tabs} />
    </Stack.Navigator>
  );
};

export { StackNavigation, HomeScreen, CommunityScreen, CourseScreen, ChatScreen };
